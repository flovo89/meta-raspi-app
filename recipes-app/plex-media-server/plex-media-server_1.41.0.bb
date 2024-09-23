require plex-media-server.inc

SRC_URI = "https://downloads.plex.tv/plex-media-server-new/1.41.0.8992-8463ad060/debian/plexmediaserver_1.41.0.8992-8463ad060_arm64.deb?_gl=1*10tx4j2*_gcl_au*NTI0OTYyODU4LjE3MjU5OTM1ODc.*_ga*MTg4MjkxODM1My4xNzI1OTkzNTg3*_ga_G6FQWNSENB*MTcyNjUxMzU0Mi4yLjEuMTcyNjUxNDAyNy41Mi4wLjA.;downloadfilename=plexmediaserver.deb"

SRC_URI[md5sum] = "148b042965c39753f93d7dca30ef604c"
SRC_URI[sha256sum] = "ff39d5835a590f7b377d542f66dbc84eeca2ea2c4797eb83654607cfc45b68c3"

do_install:append() {
    sed -i 's/python2\.4/python/g' ${D}/${libdir}/plexmediaserver/Resources/Plug-ins-8463ad060/Scanners.bundle/Contents/Resources/Common/VideoFiles.py

    sed -i 's/python/python/g' ${D}/${libdir}/plexmediaserver/Resources/Plug-ins-8463ad060/Framework.bundle/Contents/Resources/Versions/2/Python/bootstrap.py
}

# Temporary workaround to skip QA checks
INSANE_SKIP:${PN} += "file-rdeps"