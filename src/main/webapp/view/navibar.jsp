<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Books
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/books">Show Books</a>
            <a href="${pageContext.request.contextPath}/books/form/add">Add Book</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Journals
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="#">Show Journals</a>
        </div>
    </div>
    <div style="display: flex; justify-content: flex-end">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>