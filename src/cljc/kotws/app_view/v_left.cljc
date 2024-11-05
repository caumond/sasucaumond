(ns kotws.app-view.v-left
  "Left panel presents the menu, a picture of me when on wide screen mode, and the social links, with the source code link."
  (:require [kotws.lang :as klang]
            [kotws.components.v-labelled-image :as kvlabelled-image]
            [kotws.components.single :as ksingle]
            [kotws.components.v-space :as kvspace]
            [kotws.links :as klinks]
            [kotws.pages :as kpages]
            [kotws.components.v-lists :as kvlists]))

(def dic
  {:about-label {:en "About", :fr "A propos"},
   :biblio-label {:en "Bibliography", :fr "Bibliographie"},
   :contact {:en "Contacts", :fr "Contacts"},
   :cv-item {:en "Resume", :fr "CV"},
   :founder-label {:en "Founder", :fr "Fondateur"},
   :it-label {:en "I.T.", :fr "Informatique"},
   :or-label {:en "Operations Research", :fr "Recherche opérationnelle"},
   :sc-label {:en "Industry / Supply Chain",
              :fr "Industrie / Chaîne logistique"},
   :content-title {:en "Contents", :fr "Contenus"},
   :home-label {:en "Home", :fr "Accueil"},
   :tech-stack-label {:en "Tech stack", :fr "Stack technique"}})

(def items
  {:header-image :anthony,
   :header-link :home,
   :bottom-line-header "Anthony CAUMOND",
   :bottom-line {:founder {:fa-icon "fa-diamond"},
                 :it {:fa-icon "fa-code"},
                 :or {:fa-icon "fa-calculator"},
                 :sc {:fa-icon "fa-industry"}},
   :contacts-header :contact,
   :contacts {:linkedin {:fa-icon "fa-linkedin", :label "Linkedin"},
              :mail {:fa-icon "fa-envelope-open",
                     :href {:url "mailto:anthony@caumond.com"},
                     :label "Mail"},
              :slack {:fa-icon "fa-slack", :label "Slack"},
              :malt {:label "Malt"},
              :git-hub {:fa-icon "fa-github", :label "Github"}},
   :left-menu-header :content-title,
   :left-menu {:marked :menu?}})

(def tr (partial klang/tr dic))

(defn defaulting
  [items tr]
  (-> items
      (update
        :bottom-line
        #(kvlists/defaulting % tr klinks/route-links klang/possible-langs))
      (update
        :contacts
        #(kvlists/defaulting % tr klinks/external-links klang/possible-langs))
      (update :contacts-header ksingle/translate klang/possible-langs tr)
      (update :left-menu-header ksingle/translate klang/possible-langs tr)
      (update
        :left-menu
        (fn [{:keys [marked], :or {marked :left-menu?}}]
          (-> (filterv (comp marked second) kpages/pages)
              (kvlists/defaulting tr klinks/route-links klang/possible-langs))))
      (update :header-image klinks/image-link)))

(def defaulting* (memoize defaulting))

(defn v-left
  [l]
  (let [{:keys [bottom-line contacts left-menu header-image header-link
                left-menu-header contacts-header bottom-line-header]}
          (defaulting* items tr)]
    [:<>
     [kvlabelled-image/labelled-image header-image
      (klinks/route-link header-link) nil :full]
     [:div.w3-left-align
      [kvlists/one-per-row bottom-line-header (get bottom-line l)]
      [kvlists/small-buttons (get contacts-header l) (get contacts l)]
      [kvlists/one-per-row (get left-menu-header l) (get left-menu l)]
      [kvspace/vertical-spacing]]]))
