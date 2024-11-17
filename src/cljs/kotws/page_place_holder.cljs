(ns kotws.page-place-holder
  (:require [kotws.pages.c-home :refer [home]]
            [kotws.pages.c-about :refer [about]]
            [kotws.pages.c-biblio :refer [biblio]]
            [kotws.pages.c-it :refer [it]]
            [kotws.pages.c-teaching :refer [teaching]]
            [kotws.pages.c-o-r :refer [o-r]]
            [kotws.pages :as kpages]
            [kotws.blogs.c-this-website :refer [this-website]]
            [kotws.pages.c-sc :refer [sc]]
            [kotws.pages.c-tech-stack :refer [tech-stack]]
            [kotws.pages.c-founder :refer [founder]]
            [clojure.set :as set]))

(def kw->panel
  {:about [about],
   :biblio [biblio],
   :it [it],
   :founder [founder],
   :home [home],
   :or [o-r],
   :sc [sc],
   :this-website [this-website],
   :teaching [teaching],
   :tech-stack [tech-stack]})

(defn check-route
  "Log if there are some gaps between routes (in frontend) and pages."
  []
  (let [defined-pages (set (mapv :name (vals kpages/pages)))
        defined-routes (set (keys kw->panel))]
    (when-not (= defined-routes defined-pages)
      (let [page-wo-route (set/difference defined-pages defined-routes)
            route-wo-page (set/difference defined-routes defined-pages)]
        (js/console.error "Error: routes are ko, see errors below:")
        (when-not (empty? page-wo-route)
          (js/console.log "Page without route" (pr-str page-wo-route)))
        (when-not (empty? route-wo-page)
          (js/console.log "Route without page" (pr-str route-wo-page)))
        (js/console.log "Well defined:"
                        (pr-str (set/intersection defined-pages
                                                  defined-routes)))
        true))))

;; To log errors before the beginning of the page loading
(check-route)

(defn page
  "map the `panel` value (a keyword) to the component itself."
  [panel]
  (let [home-panel (:home kw->panel)] (get kw->panel panel home-panel)))
