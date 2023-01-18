
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile

ARG BUILD_FROM=ghcr.io/hassio-addons/base:13.0.0
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

ARG N8N_VERSION
RUN \
		apk add --no-cache --virtual .build-dependencies \
        g++=12.2.1_git20220924-r4 \
        gcc=12.2.1_git20220924-r4 \
        libc-dev=0.7.2-r3 \
        linux-headers=5.19.5-r0 \
        make=4.3-r1 \
        py3-pip=22.3.1-r1 \
        python3-dev=3.10.9-r1 \
        python3=3.10.9-r1 \
    \
    && apk add --no-cache \
        nodejs=18.12.1-r0 \
        npm=9.1.2-r0 \
        patch=2.7.6-r8 \
    \
		&& npm cache clear --force \
		&& npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
COPY run.sh /
RUN chmod a+x /run.sh