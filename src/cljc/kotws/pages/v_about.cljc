(ns kotws.pages.v-about
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]))

(def siren "905156402")
(def siret "90515640200018")

(def dic
  {:about-title {:en "About", :fr "A propos"},
   :introduce-sasu
     {:fr
        [:div
         [:p
          "Je suis travail indépendant - freelance, président de l'entreprise "
          [:span
           [klinks/a klinks/external-links :sasu-societe
            "SASU CAUMOND (cf. societe.com)"]] ", SIREN: " siren ", SIRET:"
          siret "."]
         [:p "J'ai co-fondé "
          [klinks/a klinks/external-links :hephaistox "Hephaistox"]
          " avec Mati (Mateusz Mazurczak) pour répondre aux besoins de chaîne logistique des PMIs."]
         [:h2 "Crédits"]
         [:ul
          [:li "Icones créées avec "
           [klinks/a klinks/external-links :fontawesome "fontawesome"]]
          [:li "Icones créées avec Freepik - "
           [klinks/a klinks/external-links :flaticon "Flaticon"]]]],
      :en
        [:div
         [:p "I am self-employed - freelance, president of the company "
          [:span
           [klinks/a klinks/external-links :sasu-societe
            "SASU CAUMOND (cf. societe.com)"]] ", SIREN: " siren ", SIRET:"
          siret "."]
         [:p "I co-founded "
          [klinks/a klinks/external-links :hephaistox "Hephaistox"]
          " with Mati (Mateusz Mazurczak) to meet the supply chain needs of SMEs."]
         [:h2 "Credits"]
         [:ul
          [:li "Icons created with "
           [klinks/a klinks/external-links :fontawesome "fontawesome"]]
          [:li "Icons created with Freepik - "
           [klinks/a klinks/external-links :flaticon "Flaticon"]]]]}})

(defn v-about
  [l]
  (let [current-tr (partial klang/tr dic l)]
    [:<> [:h1.text "SASU CAUMOND"] [:div.text (current-tr :introduce-sasu)]]))
