(ns kotws.pages
  "Declare here all frontend pages. Check also the routes of the frontend technology."
  (:require [kotws.sub-map :as ksubmap]))

(defn- add-url [{:keys [uri], :as page}] (assoc page :url (str "#" uri)))

(def pages
  (-> {:home {:uri "/", :fa-icon "fa-home", :menu? true},
       :biblio {:uri "/biblio", :fa-icon "fa-book", :menu? true},
       :tech-stack {:uri "/tech-stack", :fa-icon "fa-bullhorn", :menu? true},
       :founder {:uri "/founder"},
       :it {:uri "/it"},
       :or {:uri "/or"},
       :sc {:uri "/sc"},
       :teaching {:uri "/teaching", :menu? true, :fa-icon "fa-university"},
       :this-website {:uri "/this-website", :menu? true, :fa-icon "fa-globe"},
       :about {:fa-icon "fa-user", :uri "/about", :menu? true}}
      (ksubmap/add-key :name)
      (update-vals add-url)))
