
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile

ARG BUILD_FROM=ghcr.io/hassio-addons/base:13.1.0
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

ARG N8N_VERSION
RUN \
		apk add --no-cache \
			nodejs=18.12.1-r0 \
			npm=9.1.2-r0 \
		\
		&& npm cache clear --force \
		&& npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
COPY rootfs /