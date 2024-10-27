(ns kotws.links "Link library that can be automatically checked by the doctor")

(def site-url "https://caumond.fr/")

(def external-urls
  {:apics "https://www.afrscm.fr/762_p_44059/cpim.html",
   :babashka "https://github.com/babashka/babashka#installation",
   :clever-cloud "https://www.clever-cloud.com/en/",
   :clojure "https://clojure.org",
   :clojurescript "https://clojurescript.org/",
   :doom-emacs "https://github.com/doomemacs/doomemacs",
   :downstream-ope
     "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442",
   :drp "https://en.wikipedia.org/wiki/Distribution_resource_planning",
   :git-hub "https://github.com/caumond",
   :hephaistox "https://hephaistox.com",
   :isima-training
     "https://www.isima.fr/formations/formation-ingenieur/f3-systemes-dinformation-et-aide-a-la-decision/",
   :jewelry-ecommerce
     "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/",
   :plm "https://fr.wikipedia.org/wiki/Gestion_du_cycle_de_vie_(produit)",
   :re-frame "https://github.com/day8/re-frame",
   :software-purchasing
     "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec",
   :upstream-ope
     "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442"})

(def image-urls
  {:apics "cpim.png",
   :babashka "babashka.png",
   :clever-cloud "clever-cloud.svg",
   :clojure "clojure.png",
   :clojurescript "clojurescript.png",
   :doom-emacs "doom.png",
   :downstream-ope "framing.png",
   :drp "drp.png",
   :falsestart "false_start.png",
   :git-hub "gh.jpeg",
   :gonogo "gonogo.png",
   :hephaistox "hephaistox_logo.png",
   :isima-training "isima.png",
   :jewelry-ecommerce "jewelry.png",
   :market-knowledge "people_network.png",
   :plm-start "fill_the_gap.png",
   :plm "PLM.png",
   :pp "pp.png",
   :re-frame "re-frame.png",
   :software-purchasing "software_purchasing.png",
   :upstream-ope "ope_upstream.jpg"})

(def relative-urls (update-vals image-urls (fn [uri] (str "images/" uri))))

(def full-urls
  (-> (concat (->> external-urls
                   (mapv
                     (fn [[name external-url]]
                       {:type :external-url, :url external-url, :name name})))
              (->> relative-urls
                   (mapv (fn [[name relative-url]]
                           {:type :relative-url,
                            :url (str site-url relative-url),
                            :name name}))))
      vec))
