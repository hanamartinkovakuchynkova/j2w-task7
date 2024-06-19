[#ftl]

[@c.page title="Můj blog"]
    <h1>Seznam příspěvků</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Titulek</th>
            <th scope="col">Perex</th>
            <th scope="col">Datum publikace</th>
            <th scope="col">Autor</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        [#list posts.content as post]
        <tr>
            <td>${post.title}</td>
            <td>${post.perex?no_esc}</td>
            <td>datum</td>
            <td>${post.author}</td>
            <td><a href="/post/${post.slug}">Přečíst</a></td>
        </tr>
        [/#list]
        </tbody>
    </table>
[/@c.page]

