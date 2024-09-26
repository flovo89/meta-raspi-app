SUMMARY = "Setting up network configuration"
DESCRIPTION = "Copy wpa_supplicant.conf and interfaces file to the appropriate location"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

BBCLASSEXTEND = "nativesdk"

SRC_URI = "\
    file://wpa_supplicant.conf \
    file://interfaces \
    "

do_configure() {
    if [ -n "${INTERFACES_CONTENT}" ]; then
        echo "${INTERFACES_CONTENT}" > ${WORKDIR}/interfaces
        bbnote "Configuring interfaces file: "
        bbnote "$(echo "${INTERFACES_CONTENT}")"
    else 
        bbwarn "Using default interfaces file"
    fi
    if [ -n "${WPA_SUPPLICANT_CONF_CONTENT}" ]; then
        echo "${WPA_SUPPLICANT_CONF_CONTENT}" > ${WORKDIR}/wpa_supplicant.conf
        bbnote "Configuring wpa_supplicant.conf file: "
        bbnote "$(echo "${WPA_SUPPLICANT_CONF_CONTENT}")" 

        # Make sure quotes are correct
        sed -i 's/\(ssid=[[:blank:]]*\)\(.*\)/\1"\2"/' ${WORKDIR}/wpa_supplicant.conf
        sed -i 's/\(psk=[[:blank:]]*\)\(.*\)/\1"\2"/' ${WORKDIR}/wpa_supplicant.conf
    else
        bbwarn "Using default wpa_supplicant.conf"
    fi
}

do_install() {
    install -d ${D}/${sysconfdir}/
    install -m 0755 ${WORKDIR}/wpa_supplicant.conf ${D}/${sysconfdir}/

    install -d ${D}/${sysconfdir}/network
    install -m 0755 ${WORKDIR}/interfaces ${D}/${sysconfdir}/network/
}
