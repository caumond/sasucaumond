(ns kotws.pages.v-home
  (:require [kotws.language :as klang]
            [kotws.pages :as kpages]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(def dic
  {:home-msg {:en "Resume", :fr "Curriculum vitae"},
   :home-intro
     {:en
        "My professional career developed mainly three of my skills. I'm from computer science, but Supply Chain and industry are wonderful playgrounds. Operation Research is an obvious complement to decision-making concerns; and what is computer science if it is not there to help decision-making?",
      :fr
        "Ma carrière professionnelle m'a permis de développer trois grandes compétences. Je suis informaticien, mais la chaîne logistique et l'industrie sont des terrains de jeux exceptionnels. La recherche opérationnelle un complément évident pour aider à la prise de décision"},
   :next
     {:en
        "The next step is obvious to me: Assemble those skills in an offer for small and medium-sized industries, where a small team in charge is compatible with their culture and the amount of investments that make sense.",
      :fr
        "La prochaine étape est naturelle pour moi: Assembler ces compétences dans une offre pour les PMIs, où avoir une petite équipe est la culture et ce qui est compatible avec les montants des investissements."},
   :founder {:en "Hephaistox's founder", :fr "Fondateur d'Hephaistox"},
   :developper {:en "Computing", :fr "Informatique"},
   :or {:en "Mathematics", :fr "Mathématiques"},
   :sc {:en "Supply chain", :fr "Chaîne logistique"},
   :resume-download
     {:en
        "You can read my resume through these four point of views or the more classical document below.",
      :fr
        "Vous pouvez consulter mon cv avec un de ces quatre éclairages ou le document plus classique ci-dessous."}})

(defn v-home
  [l]
  (let [tr (partial klang/tr dic l)
        w "10em"]
    [:div [:h1.text (tr :home-msg)] [:p.text (tr :home-intro)] [:hr]
     (-> [:div.w3-cell-row]
         (concat (->> (select-keys kpages/pages [:developper :sc :or])
                      vals
                      (mapv (fn [{:keys [icon name url]}]
                              [:div.w3-cell.w3-mobile
                               [vclabelled-image/labelled-image nil icon
                                (tr name) w (tr name) url]]))))
         vec) [:hr] [:div.text (tr :next)]
     [:div.w3-center
      [vclabelled-image/labelled-image nil "images/hephaistox_logo.png"
       (tr :founder) w (tr :founder) (kpages/url :founder)]] [:hr]
     [:p.text (tr :resume-download)
      [vclabelled-image/labelled-image nil "images/resume.png" "resume" :medium
       ""
       (if (= :en l) "docs/caumond-resume.pdf" "docs/caumond-resume.pdf")]]]))
