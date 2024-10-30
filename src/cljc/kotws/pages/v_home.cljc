(ns kotws.pages.v-home
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-images :as kvimages]
            [kotws.components.v-lang :as kvlang]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(def dic
  {:home-msg {:en "Resume", :fr "Curriculum vitae"},
   :home-intro
     {:en
        "I have developed three major skills. Although I am a computer scientist, the supply chain and industry are exceptional playgrounds. Operational research is an obvious complement to help with decision-making.",
      :fr
        "J'ai développé trois compétences principales: Je suis informaticien, mais la chaîne logistique et l'industrie sont des terrains de jeux exceptionnels. La recherche opérationnelle un complément évident pour aider à la prise de décision."},
   :next
     {:en
        "View my resume below, or choose one of the more detailed forms from one of the four images below.",
      :fr
        "La prochaine étape est naturelle pour moi: Assembler ces compétences dans une offre pour les PMIs, où avoir une petite équipe est la culture et ce qui est compatible avec les montants des investissements."},
   :founder {:en "Hephaistox's founder", :fr "Fondateur d'Hephaistox"},
   :it {:en "Computing", :fr "Informatique"},
   :or {:en "Mathematics", :fr "Mathématiques"},
   :sc {:en "Supply chain", :fr "Chaîne logistique"},
   :resume-download
     {:en
        "You can read my resume through these four point of views or the more classical document below.",
      :fr
        "Visualisez mon cv ci-dessous, ou choisissez une des formes plus détaillées sur une des quatre images ci-dessous."}})

(def items
  {:docs {:caumond-resume {:fr {:img-link :caumond-cv, :href-link :caumond-cv},
                           :en {:img-link :caumond-resume,
                                :href-link :caumond-resume}}},
   :skills {:it {}, :sc {}, :or {:img-link :math}},
   :founding {:img-link :hephaistox}})

(def tr (partial klang/tr dic))

(defn defaulting
  [items _tr]
  (-> items
      (update :skills
              #(kvimages/defaulting % klinks/route-links klinks/image-link))
      (update :docs #(kvlang/defaulting % klinks/image-links klinks/doc-link))))

(defn v-home
  [l]
  (let [{:keys [docs skills founding]} (defaulting items tr)
        current-tr (partial tr l)
        w :small]
    [:div [:h1.text (current-tr :home-msg)]
     [:p.text (current-tr :resume-download)] [:hr]
     [kvlang/vclabelled-image l (:caumond-resume docs)]
     [:p.text (current-tr :home-intro)] [:hr]
     [kvimages/image-cells skills current-tr :small] [:hr]
     [:div.text (current-tr :next)]
     [:div.w3-center
      [vclabelled-image/labelled-image (klinks/image-link (:img-link founding))
       (klinks/route-link :founder) (current-tr :founder) w]] [:hr]]))
