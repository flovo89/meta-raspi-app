SUMMARY = "App Image"
DESCRIPTION = "App Image"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

IMAGE_FSTYPES += "ext4.gz"

IMAGE_INSTALL:append = " \
    transmission \
    plex-media-server \
    htop \
    swupdate \
    swupdate-www \
    swupdate-tools \
    u-boot-fw-utils \
    lua \
    parted \
    util-linux \
    python3 \
    glibc-utils \
"

IMAGE_FEATURES:append = " \
    debug-tweaks \
"

inherit core-image