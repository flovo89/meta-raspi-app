DESCRIPTION = "SWUpdate compound image"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit swupdate

SRC_URI = "\
    file://sw-description \
"

# images to build before building swupdate image
IMAGE_DEPENDS = "app-image"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = "app-image"

SWUPDATE_IMAGES_FSTYPES[app-image] = ".rootfs.ext4.gz"
