<%-- 
    Document   : index
    Created on : 13/02/2021, 11:41:04 AM
    Author     : Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="plantilla.jsp"/>--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link
            href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
            rel="stylesheet"
            />

        <title>Sistema de facturación</title>

        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />


        <link rel="stylesheet" href="assets/css/fontawesome.css" />
        <link rel="stylesheet" href="assets/css/templatemo-style.css" />
        <link rel="stylesheet" href="assets/css/owl.css" />
        <link rel="stylesheet" href="assets/css/lightbox.css" />
    </head>

    <body>
        <div id="page-wraper">
            <!-- Sidebar Menu -->
            <div class="responsive-nav">
                <i class="fa fa-bars" id="menu-toggle"></i>
                <div id="menu" class="menu">
                    <i class="fa fa-times" id="menu-close"></i>
                    <div class="container">
                        <div class="image">
                            <a href="ControllerPersona?accion=reload" >reload</a>
                        </div>
                        <div class="author-content">
                            <h4>   </h4>
                            <span> </span>
                        </div>
                        <nav class="main-nav" role="navigation">
                            <ul class="main-menu">
                                <li><a href="#section1">CLIENTES</a></li>
                                <li><a href="#section2">PRODUCTOS</a></li>
                                <li><a href="#section3">PEDIDOS</a></li>
                                <li><a href="#section4">DETALLES</a></li>

                            </ul>
                        </nav>
                        <div class="social-network">
                            <ul class="soial-icons">
                                <li>
                                    <a href="https://fb.com/templatemo"
                                       ><i class="fa fa-facebook"></i
                                        ></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-dribbble"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-rss"></i></a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>

            <section class="section about-me" data-section="section1">
                <div class="container">
                    <div class="section-heading">
                        <h2>facturaciones</h2>
                        <div class="line-dec"></div>
                        <span
                            ></span
                        >
                    </div>

                </div>
                <div class="container">

                    <div class="row">
                        <div class="col-md-6">
                            <jsp:include page="Mantenimientos/Persona/personaConsulta.jsp"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">

                        <jsp:include page="Mantenimientos/Persona/personaIngreso.jsp"/>


                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">

                        <jsp:include page="Mantenimientos/Persona/personaModificacion.jsp"/>
                    </div>
                    <div class="row">
                        <div class="col-md-6">

                            <jsp:include page="Mantenimientos/Persona/personaBorrar.jsp"/>
                        </div>
                        </section>




                        <%--seccion2--%>
                        <%--seccion2--%>
                        <%--seccion2--%>
                        <%--seccion2--%>
                        <section class="section my-services" data-section="section2">
                            <div class="container">
                                <div class="section-heading">
                                    <h2>facturaciones</h2>
                                    <div class="line-dec"></div>
                                    <span
                                        ></span
                                    >
                                </div>

                            </div>
                            <div class="container">

                                <div class="row">
                                    <div class="col-md-6">
                                        <jsp:include page="Mantenimientos/Producto/productoConsulta.jsp"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6">

                                    <jsp:include page="Mantenimientos/Producto/productoIngreso.jsp"/>


                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">

                                    <jsp:include page="Mantenimientos/Producto/productoModificacion.jsp"/>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">

                                        <jsp:include page="Mantenimientos/Producto/productoBorrar.jsp"/>
                                    </div>
                                    </section>




                                    <section class="section my-work" data-section="section3">
                                       <div class="col-md-6">

                                        <jsp:include page="Mantenimientos/Pedido/pedidoIngreso.jsp"/>
                                    </div>
                                    </section>

                                    <section class="section contact-me" data-section="section4">
                                        <div class="container">
                                            <div class="section-heading">
                                                <h2>Contact Me</h2>
                                                <div class="line-dec"></div>
                                                <span
                                                    >Fusce eget nibh nec justo interdum condimentum. Morbi justo ex,
                                                    efficitur at ante ac, tincidunt maximus ligula. Lorem ipsum dolor
                                                    sit amet, consectetur adipiscing elit.</span
                                                >
                                            </div>
                                            <div class="row">
                                                <div class="right-content">
                                                    <div class="container">
                                                        <form id="contact" action="" method="post">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <fieldset>
                                                                        <input
                                                                            name="name"
                                                                            type="text"
                                                                            class="form-control"
                                                                            id="name"
                                                                            placeholder="Your name..."
                                                                            required=""
                                                                            />
                                                                    </fieldset>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <fieldset>
                                                                        <input
                                                                            name="email"
                                                                            type="text"
                                                                            class="form-control"
                                                                            id="email"
                                                                            placeholder="Your email..."
                                                                            required=""
                                                                            />
                                                                    </fieldset>
                                                                </div>
                                                                <div class="col-md-12">
                                                                    <fieldset>
                                                                        <input
                                                                            name="subject"
                                                                            type="text"
                                                                            class="form-control"
                                                                            id="subject"
                                                                            placeholder="Subject..."
                                                                            required=""
                                                                            />
                                                                    </fieldset>
                                                                </div>
                                                                <div class="col-md-12">
                                                                    <fieldset>
                                                                        <textarea
                                                                            name="message"
                                                                            rows="6"
                                                                            class="form-control"
                                                                            id="message"
                                                                            placeholder="Your message..."
                                                                            required=""
                                                                            ></textarea>
                                                                    </fieldset>
                                                                </div>
                                                                <div class="col-md-12">
                                                                    <fieldset>
                                                                        <button type="submit" id="form-submit" class="button">
                                                                            Send Message
                                                                        </button>
                                                                    </fieldset>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </section>
                                </div>

                                <!-- Scripts -->
                                <!-- Bootstrap core JavaScript -->
                                <script src="vendor/jquery/jquery.min.js"></script>
                                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                <script src="assets/js/isotope.min.js"></script>
                                <script src="assets/js/owl-carousel.js"></script>
                                <script src="assets/js/lightbox.js"></script>
                                <script src="assets/js/custom.js"></script>
                                <script>
                                    //according to loftblog tut
                                    $(".main-menu li:first").addClass("active");

                                    var showSection = function showSection(section, isAnimate) {
                                        var direction = section.replace(/#/, ""),
                                                reqSection = $(".section").filter(
                                                '[data-section="' + direction + '"]'
                                                ),
                                                reqSectionPos = reqSection.offset().top - 0;

                                        if (isAnimate) {
                                            $("body, html").animate(
                                                    {
                                                        scrollTop: reqSectionPos
                                                    },
                                                    800
                                                    );
                                        } else {
                                            $("body, html").scrollTop(reqSectionPos);
                                        }
                                    };

                                    var checkSection = function checkSection() {
                                        $(".section").each(function () {
                                            var $this = $(this),
                                                    topEdge = $this.offset().top - 80,
                                                    bottomEdge = topEdge + $this.height(),
                                                    wScroll = $(window).scrollTop();
                                            if (topEdge < wScroll && bottomEdge > wScroll) {
                                                var currentId = $this.data("section"),
                                                        reqLink = $("a").filter("[href*=\\#" + currentId + "]");
                                                reqLink
                                                        .closest("li")
                                                        .addClass("active")
                                                        .siblings()
                                                        .removeClass("active");
                                            }
                                        });
                                    };

                                    $(".main-menu").on("click", "a", function (e) {
                                        e.preventDefault();
                                        showSection($(this).attr("href"), true);
                                    });

                                    $(window).scroll(function () {
                                        checkSection();
                                    });
                                </script>
                                </body>
                                </html>

                                </html>