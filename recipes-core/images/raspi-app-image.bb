SUMMARY = "Raspberry pi applications"
DESCRIPTION = "Image adding inclusions for applications for raspi build"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-base-network-setup.bb

IMAGE_INSTALL += " \
    htop \
    python3 \
    python3-cython \
    python3-pip \
    tensorflow \
    "
