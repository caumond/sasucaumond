(ns kotws.pages
  "Declare here all frontend pages. Check also the routes of the frontend technology.")

(def pages
  (->> {:home {:uri "/", :icon "fa-home", :menu? true},
        :biblio {:uri "/biblio", :icon "fa-book", :menu? true},
        :tech-stack {:uri "/tech-stack", :icon "fa-bullhorn", :menu? true},
        :founder {:uri "/founder"},
        :developper {:uri "/developper", :icon "images/it.png"},
        :or {:uri "/or", :icon "images/math.png"},
        :sc {:uri "/sc", :icon "images/sc.png"},
        :about {:icon "fa-user", :uri "/about", :menu? true}}
       (mapv (fn [[name {:keys [uri], :as page}]] [name
                                                   (assoc page
                                                     :url (str "#" uri)
                                                     :name name)]))
       (into {})))

(def home-uri (get-in pages [:home :uri]))
(def home-url (get-in pages [:home :url]))

(defn uri [kw] (get-in pages [kw :uri] home-uri))
(defn url [kw] (get-in pages [kw :url] home-uri))
