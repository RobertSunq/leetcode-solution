import asyncio
import aiohttp
import os
import time
from functools import partial
from .config import default_config as config


def mkdir(path):
    if not os.path.exists(path):
        os.makedirs(path)
        print(f'{path} 已创建！')
    else:
        print(f'{path} 已存在！')
    return os.path.abspath(path)


# 异步 request
async def request(url='', method='get', cookies='', headers='', **kwargs):
    async with aiohttp.ClientSession(cookies=cookies) as session:
        async with session.request(method=method,
                                   url=url,
                                   headers=headers,
                                   **kwargs) as resp:
            return await resp.read()


# 异步调度函数
async def handle_tasks(loop, func, args):
    if isinstance(args, list):
        tasks = {
            asyncio.ensure_future(func(**arg)): partial(func, **arg)
            for arg in args
        }
        # loop.run_until_complete(asyncio.wait(tasks))
        pending = set(tasks.keys())
        res = []
        while pending:
            finished, pending = await asyncio.wait(
                pending, return_when=asyncio.FIRST_COMPLETED)
            time.sleep(config.task_time_interval)
            for task in finished:
                if task.exception():
                    cor = tasks[task]
                    print(f"{cor} has error: {task.exception()} \nretry again")
                    new_task = asyncio.ensure_future(cor())
                    tasks[new_task] = cor
                    pending.add(new_task)
                else:
                    res.append(task.result())
        return res
    elif isinstance(args, str):
        task = asyncio.ensure_future(func(args))
        loop.run_until_complete(task)
        return [task.result()]
