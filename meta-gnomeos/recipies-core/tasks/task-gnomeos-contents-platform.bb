#
# Copyright (C) 2011 Colin Walters <walters@verbum.org>
#
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY_${PN} = "1"

PR = "1"

RDEPENDS_${PN} += "\
	 util-linux-libuuid \
	 which \
	 libffi \
	 tiff \
	 jpeg \
	 libexif \
	 libstdc++ \
	 gnutls \
	 libogg \
	 eglibc-gconvs \
	 eglibc-binaries \
	 eglibc-localedatas \
	 eglibc-charmaps \
	 eglibc-utils \
	 eglibc-locale \
	 ncurses-terminfo-base \
	 cpio \
	 dejavu-fonts-ttf \
	 libvorbis \
	 speex \
	 alsa-lib \
	 cracklib \
	 pciutils \
	 base-files \
	 base-passwd \
	 update-alternatives-cworth \
	 coreutils \
	 sed \
	 findutils \
	 bash \
	 tar \
	 grep \
	 gawk \
	 gzip \
	 less \
	 curl \
	 tzdata \
	 tzdata-africa \
	 tzdata-americas \
	 tzdata-antarctica \
	 tzdata-arctic \
	 tzdata-asia \
	 tzdata-atlantic \
	 tzdata-australia \
	 tzdata-europe \
	 tzdata-misc \
	 tzdata-pacific \
	 tzdata-posix \
	 tzdata-right \
	 libsndfile1 \
	 icu \
	 attr \
	 acl \
	 bzip2 \
	 xz \
	 ncurses \
	 libvorbis \
	 speex \
	 nspr \
	 krb5 \
	 dejavu-fonts-ttf \
	 nss-altfiles \
	 llvm \
	 sqlite3 libsqlite3 \
	 expat \
	 cyrus-sasl \
	 elfutils \
	 "
