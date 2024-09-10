IMAGE_FSTYPES += "ext4.gz"

require recipes-core/images/core-image-base-network-setup.bb

IMAGE_INSTALL:append = " \
    transmission \
    "
