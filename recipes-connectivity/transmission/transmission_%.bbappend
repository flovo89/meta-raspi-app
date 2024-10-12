FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
  file://transmission-daemon.service \
  file://settings.json \
  "

inherit systemd

SYSTEMD_SERVICE:${PN} = "transmission-daemon.service"

FILES:${PN} += " \
  ${sysconfdir}/transmission/settings.json \
  "

do_install:append() {
  install -d ${D}${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/transmission-daemon.service ${D}${systemd_system_unitdir}/

  install -d ${D}${sysconfdir}/transmission
  install -m 0644 ${WORKDIR}/settings.json ${D}${sysconfdir}/transmission
}


