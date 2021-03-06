DESCRIPTION = "Image loading library for GTK+"
HOMEPAGE = "http://www.gtk.org/"
BUGTRACKER = "https://bugzilla.gnome.org/"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7 \
                    file://gdk-pixbuf/gdk-pixbuf.h;endline=26;md5=5066b71daefeff678494fffa3040aba9"

SECTION = "libs"

DEPENDS = "libpng glib-2.0 jpeg"

SRC_URI = "http://ftp.acc.umu.se/pub/GNOME/sources/gdk-pixbuf/2.24/gdk-pixbuf-${PV}.tar.bz2 \
           file://hardcoded_libtool.patch \
           file://configure_fix.patch \
           "

SRC_URI[md5sum] = "d8ece3a4ade4a91c768328620e473ab8"
SRC_URI[sha256sum] = "38d2630314e6d91976bffd833236f84fefa440a9038f86dc422820a39f2e3700"

inherit autotools pkgconfig gettext

LIBV = "2.10.0"

EXTRA_OECONF = "\
  --without-libtiff \
  --with-libpng \
  --disable-introspection \
"

FILES_${PN} = "${bindir}/gdk-pixbuf-query-loaders \
	${libdir}/lib*.so.*"

FILES_${PN}-dev += " \
	${bindir}/gdk-pixbuf-csource \
	${includedir}/* \
	${libdir}/gdk-pixbuf-2.0/${LIBV}/loaders/*.la \
"

FILES_${PN}-dbg += " \
        ${libdir}/.debug/* \
	${libdir}/gdk-pixbuf-2.0/${LIBV}/loaders/.debug/* \
"

postinst_pixbufloader () {
if [ "x$D" != "x" ]; then
    exit 1
fi

GDK_PIXBUF_MODULEDIR=${libdir}/gdk-pixbuf-2.0/${LIBV}/loaders gdk-pixbuf-query-loaders --update-cache

test -x ${bindir}/gtk-update-icon-cache && gtk-update-icon-cache  -q ${datadir}/icons/hicolor
}

PACKAGES_DYNAMIC += "gdk-pixbuf-loader-*"
PACKAGES_DYNAMIC_virtclass-native = ""

python populate_packages_prepend () {
	postinst_pixbufloader = d.getVar("postinst_pixbufloader", 1)

	loaders_root = bb.data.expand('${libdir}/gdk-pixbuf-2.0/${LIBV}/loaders', d)

	do_split_packages(d, loaders_root, '^libpixbufloader-(.*)\.so$', 'gdk-pixbuf-loader-%s', 'GDK pixbuf loader for %s', postinst_pixbufloader)
}

do_install_append_virtclass-native() {
#Use wrapper script rather than binary as required libtool library is not installed now
	GDK_PIXBUF_MODULEDIR=${D}${libdir}/gdk-pixbuf-2.0/2.10.0/loaders ${S}/gdk-pixbuf/gdk-pixbuf-query-loaders > ${D}${libdir}/gdk-pixbuf-2.0/2.10.0/loaders.cache
	sed -i -e 's#${D}##g' ${D}${libdir}/gdk-pixbuf-2.0/2.10.0/loaders.cache
	find ${D}${libdir} -name "libpixbufloader-*.la" -exec rm \{\} \;
}
BBCLASSEXTEND = "native"
