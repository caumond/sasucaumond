(ns kotws.app-view.left-panel-data
  "Left panel presents the menu, a picture of me when on wide screen mode, and the social links, with the source code link."
  (:require [kotws.multi-language :as kmulti-language]
            [kotws.components.labelled-image :as klabelled-image]
            [kotws.components.lists :as klists]))

(def dic
  {:about-label {:en "About", :fr "A propos"},
   :biblio-label {:en "Bibliography", :fr "Bibliographie"},
   :contact {:en "Contacts", :fr "Contacts"},
   :cv-item {:en "Resume", :fr "CV"},
   :founder-label {:en "Founder", :fr "Fondateur"},
   :developper-label {:en "Developper", :fr "Développeur"},
   :or-label {:en "Operations Research", :fr "Recherche opérationnelle"},
   :industry-label {:en "Industry / Supply Chain",
                    :fr "Industrie / Chaîne logistique"},
   :content-title {:en "Contents", :fr "Contenus"},
   :home-label {:en "Home", :fr "Accueil"},
   :techstack-label {:en "Tech stack", :fr "Stack technique"}})

(defn skills
  [l]
  (-> {:founder {:icon "fa-diamond", :href "#/founder"},
       :developper {:icon "fa-code", :href "#/developper"},
       :or {:icon "fa-calculator", :href "#/or"},
       :industry {:icon "fa-industry", :href "#/sc"}}
      (kmulti-language/default-and-translate
        [:label]
        (partial kmulti-language/tr dic l))))

(defn pages
  [l]
  (-> {:home {:icon "fa-home", :href "#/"},
       :techstack {:icon "fa-bullhorn", :href "#/tech-stack"},
       :biblio {:icon "fa-book", :href "#/biblio"},
       :about {:icon "fa-user", :href "#/about"}}
      (kmulti-language/default-and-translate
        [:label]
        (partial kmulti-language/tr dic l))))

(defn social
  []
  (-> {:linkedin {:icon "fa-linkedin",
                  :label "Linkedin",
                  :href "https://www.linkedin.com/in/anthony-caumond-a365b15/"},
       :mail {:icon "fa-envelope-open",
              :href "mailto:caumond@gmail.com",
              :label "Mail"},
       :slack {:icon "fa-slack",
               :label "Slack",
               :href "https://clojurians.slack.com/team/U018QDQGZ9Q"},
       :github {:icon "fa-github",
                :href "https://github.com/caumond",
                :label "Github"}}
      (kmulti-language/default-and-translate
        []
        (partial kmulti-language/tr dic nil))))

(defn v-panel
  "Panel view."
  [l]
  (let [tr (partial kmulti-language/tr dic l)]
    [:<>
     [klabelled-image/labelled-image "/images/anthonycaumond.jpg"
      "Anthony's picture" nil nil]
     [:h3.w3-center.w3-animate-opacity "Anthony CAUMOND"] [:hr]
     [:div.w3-left-align [klists/one-per-row (skills l)] [:hr]
      (->> (klists/small-buttons (tr :contact) (social)))
      [klists/one-per-row (tr :content-title) (pages l)] [:hr]]]))
