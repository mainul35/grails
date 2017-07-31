package com.hmtmcse.blog

class UrlMappings {

    static mappings = {
        "/blog-category/$url"(controller: "blogPage", action: "blogCategory")
        "/blog/$url"(controller: "blogPage", action: "post")
    }
}
