SUMMARY = "App Image"
DESCRIPTION = "App Image"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${GPLv2_LICENSE_PATH};md5=${GPLv2_LICENSE_CHECKSUM}"

IMAGE_INSTALL:append = " \
    transmission \
    plex-media-server \
    network-configuration \
    bluez5 \
    bridge-utils \
    hostapd \
    iptables \
    htop \
    wpa-supplicant \
    swupdate \
    swupdate-www \
    swupdate-tools \
    u-boot-fw-utils \
    lua \
    parted \
    util-linux \
    python3 \
"

IMAGE_FEATURES:append = " \
    debug-tweaks \
"