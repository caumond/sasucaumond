(ns kotws.app-view.v-left
  "Left panel presents the menu, a picture of me when on wide screen mode, and the social links, with the source code link."
  (:require [kotws.language :as klang]
            [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.pages :as kpages]
            [kotws.components.v-lists :as kvlists]))

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
   :tech-stack-label {:en "Tech stack", :fr "Stack technique"}})


(def skills
  (letfn [(s [l]
            (-> {:founder {:icon "fa-diamond", :href "#/founder"},
                 :developper {:icon "fa-code", :href "#/developper"},
                 :or {:icon "fa-calculator", :href "#/or"},
                 :industry {:icon "fa-industry", :href "#/sc"}}
                (klang/default-and-translate [:label]
                                             (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (s l)]))
         (into {}))))

(def pages
  (letfn [(p [l]
            (let [x (->> (vals kpages/pages)
                         (filter :menu?)
                         (mapv (fn [{:keys [name icon url]}] [name
                                                              {:icon icon,
                                                               :href url}]))
                         (into {}))]
              (-> x
                  (klang/default-and-translate [:label]
                                               (partial klang/tr dic l)))))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (p l)]))
         (into {}))))

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
      (klang/default-and-translate [] (partial klang/tr dic nil))))

(defn v-left
  "Panel view."
  [l]
  (let [tr (partial klang/tr dic l)]
    [:<>
     [kvlabelled-image/labelled-image "/images/anthonycaumond.jpg"
      "Anthony's picture" nil nil "#/home"]
     [:div.w3-left-align [kvlists/one-per-row "Anthony CAUMOND" (get skills l)]
      (->> (kvlists/small-buttons (tr :contact) (social)))
      [kvlists/one-per-row (tr :content-title) (get pages l)] [:hr]]]))
