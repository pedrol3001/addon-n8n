
# https://developers.home-assistant.io/docs/add-ons/configuration#add-on-dockerfile
ARG BUILD_FROM
ARG N8N_VERSION
FROM $BUILD_FROM

RUN npm install n8n@$N8N_VERSION -g

# Copy root filesystem
COPY rootfs /