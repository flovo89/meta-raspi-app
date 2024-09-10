SUMMARY = "Transmission torrent client"
DESCRIPTION = "Fast and easy bitTorrent client"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/transmission/transmission"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${GPLv2_LICENSE_PATH};md5=${GPLv2_LICENSE_CHECKSUM}"

BBCLASSEXTEND = "nativesdk"

TRANSMISSION_BRANCH ?= "main"
TRANSMISSION_GIT_URL ?= "git://github.com/transmission/transmission.git;protocol=https;branch=${TRANSMISSION_BRANCH};submodules=1"

SRC_URI = "\
    ${TRANSMISSION_GIT_URL} \
    "

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
  -DCMAKE_BUILD_TYPE=Release \
  "


