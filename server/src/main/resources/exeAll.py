import os
import mysql.connector

# Datenbankverbindungsinformationen
db_config = {
    'host': 'localhost',
    'port': 3306,
    'user': 'root',
    'password': 'anisasSexyStock'
}

def execute_sql_file(file_paths):
    # Verbindung zur Datenbank herstellen
    connection = mysql.connector.connect(**db_config)
    cursor = connection.cursor()

    # SQL-Datei ausführen
    for file_path in file_paths:
        print(f"Execute {file_path}")
        with open(file_path, 'r', encoding='utf-8') as file:
            sql_script = file.read()
            for statement in sql_script.split(';'):
                if statement.strip():
                    cursor.execute(statement)
                    connection.commit()

    # Verbindung schließen
    cursor.close()
    connection.close()


if __name__ == '__main__':
    # Ausführen der SQL-Dateien
    execute_sql_file(['init_tables.sql', 'insert_tables.sql'])


