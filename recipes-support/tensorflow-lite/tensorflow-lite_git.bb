DESCRIPTION = "TensorFlow Lite C++ Library"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=64a34301f8e355f57ec992c2af3e5157"

SRCREV = "64c3d382cadf7bbe8e7e99884bede8284ff67f56"

SRC_URI = " \
	git://github.com/tensorflow/tensorflow.git;branch=r2.0 \
	file://0001-creating-a-new-Makefile-that-triggers-Makefile.inter.patch \
	file://0001-Tailor-our-own-Makefile-for-arm-arm64-cross-compilat.patch \
	file://0001-Fix-asm-mov-error.patch \
	file://0001-Remove-GPU-and-NNAPI.patch \
	file://0001-Use-wget-instead-of-curl-to-fetch-https-source.patch \
"
PR = "r0"

S = "${WORKDIR}/git"

DEPENDS = "gzip-native unzip-native zlib"

do_configure(){
	${S}/tensorflow/lite/tools/make/download_dependencies.sh
}

CXXFLAGS += "--std=c++11"
FULL_OPTIMIZATION += "-O3 -DNDEBUG"

do_install(){
	install -d ${D}/${libdir}
	cp -r ${S}/tensorflow/lite/tools/make/gen/lib/* ${D}/${libdir}

	cd ${S}
	find tensorflow/lite -name "*.h" | cpio -pdm ${D}/${includedir}/
	find tensorflow/lite -name "*.inc" | cpio -pdm ${D}/${includedir}/

	install -d ${D}/${includedir}/tensorflow_lite
	cd ${S}/tensorflow/lite
	cp --parents $(find . -name "*.h*") ${D}/${includedir}/tensorflow_lite

	install -d ${D}/${bindir}/${PN}/examples
	install -m 0555 ${S}/tensorflow/lite/tools/make/gen/bin/label_image ${D}/${bindir}/${PN}/examples
	install -m 0555 ${S}/tensorflow/lite/examples/label_image/testdata/grace_hopper.bmp ${D}/${bindir}/${PN}/examples
	install -m 0555 ${S}/tensorflow/lite/tools/make/gen/bin/minimal ${D}/${bindir}/${PN}/examples
    install -m 0555 ${S}/tensorflow/lite/tools/make/gen/bin/benchmark_model ${D}/${bindir}/${PN}/examples
	cd ${D}/${bindir}
}