SUMMARY = "Plex Media Server"
DESCRIPTION = "Plex Media Server organizes video, music, and photos from personal media libraries and streams them to smart TVs, streaming boxes, and mobile devices."
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

S = "${WORKDIR}"

RDEPENDS:${PN} += " \
    python3 \
    "
DEPENDS += " \
    python3-native \
    "

INSANE_SKIP:${PN} += "already-stripped"

FILES:${PN} += " \
    /usr/lib/plexmediaserver \
    "

do_unpack() {
    cp ${DL_DIR}/plexmediaserver.deb ${WORKDIR}
}

do_install() {
    # Extract the .deb package
    ar x ${WORKDIR}/plexmediaserver.deb
    tar -xvf ${S}/data.tar.xz -C ${D}

    # Adjust permissions for necessary directories
    #chmod -R 755 ${D}/opt/plexmediaserver
}