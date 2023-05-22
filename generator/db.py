from .config import default_config as config
import sqlite3
import mysql.connector
import os


class db:
    def __init__(self):
        self.type = config.db_type

    def create_conn(self):
        if self.type == 'mysql':
            return mysql.connector.connect(user=config.db_user_name,
                                           password=config.db_user_password,
                                           host=config.db_host,
                                           port=config.db_port,
                                           database=config.db_database)
        else:
            sqlite3_path = os.path.abspath(os.path.join(config.db_sqlite3_path))
            if not os.path.exists(sqlite3_path):
                print("create dir ", sqlite3_path)
                os.mkdir(sqlite3_path)
            db_path = os.path.join(sqlite3_path, "leetcode.db")
            return sqlite3.connect(db_path)


if __name__ == "__main__":
    pass