
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile
ARG N8N_VERSION

FROM ${BUILD_FROM}



RUN apk add --no-cache \
        nodejs=18.12.1-r0 \
        npm=9.1.2-r0 \
		\
		&& npm install n8n@${N8N_VERSION} -g

# Copy root filesystem
COPY rootfs /