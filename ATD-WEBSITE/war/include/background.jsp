<style>
body {
	padding-top: 20px;
	padding-bottom: 20px;
	/* Location of the image */
	background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.6)),
		url("${pageContext.request.contextPath}/images/background.jpg");
	/* Background image is centered vertically and horizontally at all times */
	background-position: center center;
	/* Background image doesn't tile */
	background-repeat: no-repeat;
	/* Background image is fixed in the viewport so that it doesn't move when 
     the content's height is greater than the image's height */
	background-attachment: fixed;
	/* This is what makes the background image rescale based
     on the container's size */
	background-size: cover;
	/* Set a background color that will be displayed
     while the background image is loading */
	/*background-color: rgb(236, 240, 241); */
}
</style>