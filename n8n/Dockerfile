
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile

ARG BUILD_FROM
FROM ${BUILD_FROM}

ARG N8N_VERSION
RUN \
		apk add --no-cache --virtual .build-dependencies \
        py3-pip=22.3.1-r1 \
        python3=3.10.9-r1 \
    \
    && apk add --no-cache \
        nodejs=18.12.1-r0 \
        npm=9.1.2-r0 \
    \
		&& npm cache clear --force \
		&& npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
COPY rootfs /