
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
        make \
        py3-pip \
        python3-dev \
        python3 \
    \
    && apk add --no-cache \
        nodejs \
        npm \
    \
    && npm cache clear --force \
    && npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
COPY rootfs /