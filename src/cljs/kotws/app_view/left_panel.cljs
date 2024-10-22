(ns kotws.app-view.left-panel
  "Left panel presents the menu, a picture of me when on wide screen mode, and the social links, with the source code link."
  (:require [kotws.components.labelled-image :as klabelled-image]
            [kotws.components.lists :as klists]
            [kotws.multi-language :as ml]))

(defn tr
  "Text matching key `k` and translated to current language."
  [k]
  (-> {:about-item {:en "About", :fr "A propos"},
       :biblio-item {:en "Bibliography", :fr "Bibliographie"},
       :contact {:en "Contacts", :fr "Contacts"},
       :cv-item {:en "Resume", :fr "CV"},
       :founder {:en "Founder", :fr "Fondateur"},
       :developper {:en "Developper", :fr "Développeur"},
       :or {:en "Operations Research", :fr "Recherche opérationnelle"},
       :industry {:en "Industry / Supply Chain",
                  :fr "Industrie / Chaîne logistique"},
       :content {:en "Contents", :fr "Contenus"},
       :home-item {:en "Home", :fr "Accueil"},
       :techstack-item {:en "Tech stack", :fr "Stack technique"}}
      (ml/tr* k)))

(defn v-panel
  "Panel view."
  []
  [:<> [:header.w3-container.w3-center]
   [klabelled-image/labelled-image "/images/anthonycaumond.jpg"
    "Anthony's picture" nil nil]
   [:h3.w3-center.w3-animate-opacity "Anthony CAUMOND"] [:hr.rounded.w-hr]
   [:div.w3-left-align
    (klists/one-per-row nil
                        (->> [["fa-diamond" :founder "#/founder"]
                              ["fa-code" :developper "#/developper"]
                              ["fa-calculator" :or "#/or"]
                              ["fa-industry" :industry "#/sc"]]
                             (mapv #(update % 1 tr)))) [:hr]
    (->> [["fa-linkedin" ""
           "https://www.linkedin.com/in/anthony-caumond-a365b15/"]
          ["fa-envelope-open" "" "mailto:caumond@gmail.com"]
          ["fa-slack" "" "https://clojurians.slack.com/team/U018QDQGZ9Q"]
          ["fa-github" "" "https://github.com/caumond"]]
         (klists/small-buttons (tr :contact)))
    [klists/one-per-row (tr :content)
     (->> [["fa-home" :home-item "#/"] ["fa-graduation-cap" :cv-item "#/resume"]
           ["fa-bullhorn" :techstack-item "#/tech-stack"]
           ["fa-book" :biblio-item "#/biblio"]
           ["fa-user" :about-item "#/about"]]
          (mapv #(update % 1 tr)))] [:hr]]])

(defn panel [] (v-panel))
