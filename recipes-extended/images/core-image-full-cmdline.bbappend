IMAGE_FSTYPES += "ext4.gz"

IMAGE_INSTALL:append = " \
    transmission \
    plex-media-server \
    network-configuration \
    bluez5 \
    bridge-utils \
    hostapd \
    iptables \
    htop \
    wpa-supplicant \
    python3 \
    "

IMAGE_FEATURES:append = " \
    debug-tweaks \
    "
