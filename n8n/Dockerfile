
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile

ARG BUILD_FROM
FROM ${BUILD_FROM}

ARG N8N_VERSION
RUN \
		apk add --no-cache --virtual .build-dependencies \
        g++ \
        gcc \
        libc-dev \
        linux-headers \
        make=4.3-r1 \
        py3-pip \
        python3-dev \
        python3 \
    \
    && apk add --no-cache \
        nodejs=16.19.0-r0 \
        npm=8.18.3-r0 \
    \
		&& npm cache clear --force \
		&& npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
# Copy root filesystem
COPY rootfs /