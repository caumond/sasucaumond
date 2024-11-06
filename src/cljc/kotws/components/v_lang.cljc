(ns kotws.components.v-lang
  "Language based components"
  (:require [kotws.components.v-labelled-image :as vclabelled-image]
            [kotws.components.items :as kcitems]))

(defn defaulting
  "Translates `img-link` and `href-link` with `image-dic` and `doc-dic`"
  [items image-dic doc-dic]
  (update-vals items
               (fn [doc]
                 (-> doc
                     (kcitems/apply-dic [:img-link] image-dic)
                     (kcitems/apply-dic [:href-link] doc-dic)))))

(def defaulting* (memoize defaulting))

(defn vclabelled-image
  "Show an image based on a language.

  * `l` is the language to display
  * ` doc-links` contains two keys
     * `img-link` what is shown
     * `href-link` destination link when actioned"
  ([l doc-links] (vclabelled-image l doc-links nil))
  ([l doc-links label] (vclabelled-image l doc-links label :medium))
  ([l doc-links label size]
   (let [{:keys [img-link href-link]} (get doc-links l)]
     [vclabelled-image/labelled-image img-link href-link label size])))

(defn vclabelled-rounded-image
  "Show an image based on a language.

  * `l` is the language to display
  * ` doc-links` contains two keys
     * `img-link` what is shown
     * `href-link` destination link when actioned"
  ([l doc-links] (vclabelled-image l doc-links nil))
  ([l doc-links label] (vclabelled-image l doc-links label :medium))
  ([l doc-links label size]
   (let [{:keys [img-link href-link]} (get doc-links l)]
     [vclabelled-image/labelled-image-circle img-link href-link label size])))
