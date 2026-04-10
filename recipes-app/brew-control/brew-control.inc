AUTHOR = "Florian Vogel <florian.vogel@comet.ch>"
HOMEPAGE = "http://www.comet-pct.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

BREW_CONTROL_BRANCH ?= "main"
BREW_CONTROL_GIT_URL ?= "git://git@github.com/flovo89/BrewControl.git;protocol=ssh;branch=${BREW_CONTROL_BRANCH}"

SRC_URI = " \
  ${BREW_CONTROL_GIT_URL} \
  "

S = "${WORKDIR}/git/src/brew-control"

inherit cargo

#do_configure:append() {
#    cp -r ${S}/vendor/* ${WORKDIR}/cargo_home/bitbake
#}

