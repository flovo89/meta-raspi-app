SUMMARY = "Transmission torrent client"
DESCRIPTION = "Fast and easy bitTorrent client"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/transmission/transmission"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

BBCLASSEXTEND = "nativesdk"

TRANSMISSION_BRANCH ?= "main"
TRANSMISSION_GIT_URL ?= "git://github.com/transmission/transmission.git;protocol=https;branch=${TRANSMISSION_BRANCH};submodules=1"

SRC_URI = "\
    ${TRANSMISSION_GIT_URL} \
    "

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += " \
  -DCMAKE_BUILD_TYPE=Release \
  "


