import subprocess
import glob

# Alle SQL-Skriptdateien im Verzeichnis finden
sql_files = glob.glob("./*.sql")

# MySQL-Verbindungsdaten
username = "root"
password = "anisasSexyStock"
host = "localhost"
port = "3306"

# Für jede SQL-Datei das Skript ausführen
for sql_file in sql_files:
    # Befehl zum Ausführen des SQL-Skripts mit dem mysql Befehl
    command = f"mysql -u {username} -p{password} -h {host} -P {port} < {sql_file}"
    print(command)
    subprocess.run(command, shell=True)