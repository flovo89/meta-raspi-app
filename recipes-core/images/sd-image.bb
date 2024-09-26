SUMMARY = "SD Image"
DESCRIPTION = "SD Image build"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${GPLv2_LICENSE_PATH};md5=${GPLv2_LICENSE_CHECKSUM}"

require app-image.bb

IMAGE_FSTYPES += " wic"
WKS_FILE = "wic/sd-image.wks"

do_rootfs[depends] += " \
    app-image:do_install \
"

inherit core-image