{
  "protocol": "{{ .protocol }}",
  "host": "{{ .host }}",
  "port": "{{ .port }}",
  "ssl_cert": "{{ .ssl_cert }}",
  "ssl_key": "{{ .ssl_key }}",
  "database": {
    "type": "{{ .db_type }}",
    "mysqldb": {
      "database": "{{ .db_name }}",
      "host": "{{ .db_host }}",
      "port": "{{ .db_port }}",
      "user": "{{ .db_user }}",
      "password": "{{ .db_password }}"
    },
    "postgresdb": {
      "database": "{{ .db_name }}",
      "host": "{{ .db_host }}",
      "port": "{{ .db_port }}",
      "user": "{{ .db_password }}",
      "password": "{{ .db_password }}"
    }
  },
  "hideUsagePage": true,
  "hiringBanner": {
    "enabled": false
  },
  "diagnostics": {
    "enabled": false
  },
  "versionNotifications": {
    "enabled": false
  },
  "personalization": {
    "enabled": false
  },
  "logs": {
    "level": "{{ .log_level }}"
  }
}
