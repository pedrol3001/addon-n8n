ARG BUILD_FROM=ghcr.io/hassio-addons/base-nodejs:0.1.4

# hadolint ignore=DL3006
FROM ${BUILD_FROM}
ARG BUILD_ARCH

ARG N8N_VERSION=1.33.1

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# hadolint ignore=DL3018
RUN apk add --no-cache --virtual .build-dependencies \
    build-base \
    linux-headers \
    py3-pip \
    python3-dev \
    \
    && npm install "n8n@${N8N_VERSION}" -g \
    \
    && npm cache clear --force \
    && apk del --no-cache --purge .build-dependencies \
    && rm -fr \
        /root/.cache \
        /root/.npm \
        /root/.nrpmrc \
        /tmp/*

ENV TFTPD_OPTS=''

# Copy root filesystem
COPY rootfs /

EXPOSE 3111

# Build arguments
ARG BUILD_DATE
ARG BUILD_DESCRIPTION
ARG BUILD_NAME
ARG BUILD_REF
ARG BUILD_REPOSITORY
ARG BUILD_VERSION

# Labels
LABEL \
    io.hass.name="${BUILD_NAME}" \
    io.hass.description="${BUILD_DESCRIPTION}" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="Pedro Luis <contact@pedrol.me>" \
    org.opencontainers.image.title="${BUILD_NAME}" \
    org.opencontainers.image.description="${BUILD_DESCRIPTION}" \
    org.opencontainers.image.vendor="Home Assistant N8N Add-on" \
    org.opencontainers.image.authors="Pedro Luis <contact@pedrol.me>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.url="https://addons.community" \
    org.opencontainers.image.source="https://github.com/${BUILD_REPOSITORY}" \
    org.opencontainers.image.documentation="https://github.com/${BUILD_REPOSITORY}/blob/main/README.md" \
    org.opencontainers.image.created=${BUILD_DATE} \
    org.opencontainers.image.revision=${BUILD_REF} \
    org.opencontainers.image.version=${BUILD_VERSION}
