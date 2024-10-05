SUMMARY = "Plex Media Server"
DESCRIPTION = "Plex Media Server organizes video, music, and photos from personal media libraries and streams them to smart TVs, streaming boxes, and mobile devices."
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd useradd

S = "${WORKDIR}"

RDEPENDS:${PN} += " \
    python3 \
    "
DEPENDS += " \
    python3-native \
    "

INSANE_SKIP:${PN} += "already-stripped"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-u 1000 -g plex -G root -d /usr/lib/plexmediaserver -r -s /bin/bash plex"
GROUPADD_PARAM:${PN} = "-g 1000 plex"

SYSTEMD_SERVICE:${PN} = "plexmediaserver.service"

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

    # Patch service file
    sed -i 's#/var/lib/#/tmp/#g' ${D}/${libdir}/plexmediaserver/lib/plexmediaserver.service

    # Adjust permissions for necessary directories
    #chmod -R 755 ${D}/opt/plexmediaserver

    # Use given service file
    install -d ${D}${systemd_system_unitdir}
    install -m 644 ${D}/${libdir}/plexmediaserver/lib/plexmediaserver.service ${D}${systemd_system_unitdir}/
}