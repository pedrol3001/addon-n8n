server {
    listen {{ .port }} default_server;

    include /etc/nginx/includes/server_params.conf;
    include /etc/nginx/includes/proxy_params.conf;

    location / {
        allow   172.30.32.2;
        deny    all;

        proxy_pass http://backend;

        sub_filter {{ .dummy_path }}  {{ .entry }}/;
        sub_filter_once off;
    }
}
