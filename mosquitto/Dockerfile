ARG BUILD_FROM
FROM $BUILD_FROM

# Install mosquitto + auth plugin
WORKDIR /usr/src
RUN apk add --no-cache \
        mosquitto \
        nginx \
        pwgen \
    && apk add --no-cache --virtual .build-dependencies \
        build-base \
        curl-dev \
        git \
        mosquitto-dev \
        openssl-dev \
    \
    && apk del --no-cache .build-dependencies \
    && rm -fr \
        /etc/logrotate.d \
        /etc/mosquitto/* \
        /etc/nginx/* \
        /usr/share/nginx \
        /usr/src/mosquitto-auth-plug \
        /var/lib/nginx/html \
        /var/www

# Copy rootfs
COPY rootfs /

WORKDIR /
