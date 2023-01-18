
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile

ARG BUILD_FROM
FROM ${BUILD_FROM}

ARG N8N_VERSION
RUN \
		apk add --no-cache --virtual .build-dependencies \
        python3 \
        py3-pip \
    \
    && apk add --no-cache \
        nodejs=17.9.0-r0 \
        npm=8.1.3-r0 \
    \
		&& npm cache clear --force \
		&& npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
# Copy root filesystem
COPY rootfs /