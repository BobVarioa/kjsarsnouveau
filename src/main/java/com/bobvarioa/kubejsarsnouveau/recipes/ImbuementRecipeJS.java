package com.bobvarioa.kubejsarsnouveau.recipes;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.IntBounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Optional;

public interface ImbuementRecipeJS {
    RecipeKey<Ingredient> INPUT = IngredientComponent.INGREDIENT.key("input", ComponentRole.INPUT);
    RecipeKey<ItemStack> OUTPUT_AND_COUNT = ItemStackComponent.ITEM_STACK.key("output", ComponentRole.OUTPUT);
    RecipeKey<Integer> SOURCE = NumberComponent.INT.key("source", ComponentRole.OTHER);

    RecipeKey<List<Ingredient>> PEDESTAL_ITEMS = ListRecipeComponent.create(IngredientComponent.INGREDIENT.instance(), false, false, IntBounds.of(0, Integer.MAX_VALUE), Optional.empty())
            .key("pedestalItems", ComponentRole.INPUT)
            .optional(List.of())
            .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(INPUT, OUTPUT_AND_COUNT, SOURCE, PEDESTAL_ITEMS);
}