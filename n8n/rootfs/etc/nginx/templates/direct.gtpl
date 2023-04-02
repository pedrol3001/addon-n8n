server {
    {{ if not .ssl }}
    listen {{ .port }} default_server;
    {{ else }}
    listen {{ .port }} default_server ssl http2;
    {{ end }}

    include /etc/nginx/includes/server_params.conf;
    include /etc/nginx/includes/proxy_params.conf;

    {{ if .ssl }}
    include /etc/nginx/includes/ssl_params.conf;

    ssl_certificate /ssl/{{ .certfile }};
    ssl_certificate_key /ssl/{{ .keyfile }};
    {{ end }}

    location = /auth {
        internal;
        proxy_pass              http://supervisor/auth;
        proxy_pass_request_body off;
        proxy_set_header        Content-Length "";
        proxy_set_header        X-Supervisor-Token "{{ env "SUPERVISOR_TOKEN" }}";
    }

    location / {
        auth_request /auth;
        auth_request_set $auth_status $upstream_status;

        rewrite ^{{ .entry }}(.*)$ $1 break;

        proxy_pass http://backend;
    }
}
