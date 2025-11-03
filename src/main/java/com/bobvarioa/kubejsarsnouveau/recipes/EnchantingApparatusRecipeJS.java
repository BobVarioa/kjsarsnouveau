package com.bobvarioa.kubejsarsnouveau.recipes;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.IntBounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Optional;

public interface EnchantingApparatusRecipeJS {

    RecipeKey<List<Ingredient>> PEDESTAL_ITEMS = ListRecipeComponent.create(IngredientComponent.INGREDIENT.instance(), false, false, IntBounds.of(0, Integer.MAX_VALUE), Optional.empty())
            .key("pedestalItems", ComponentRole.INPUT)
            .optional(List.of())
            .alwaysWrite();

    RecipeKey<List<Ingredient>> REAGENT = IngredientComponent.INGREDIENT.instance().asListOrSelf().key("reagent", ComponentRole.INPUT);

    RecipeKey<ItemStack> OUTPUT = ItemStackComponent.ITEM_STACK.key("result", ComponentRole.OUTPUT);

    RecipeKey<Integer> SOURCE = NumberComponent.INT.key("sourceCost", ComponentRole.OUTPUT).alt("source").optional(0);

    RecipeKey<Boolean> KEEP_NBT = BooleanComponent.BOOLEAN.key("keepNbtOfReagent", ComponentRole.OTHER).alt("keepNbt").optional(false).alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(PEDESTAL_ITEMS, REAGENT, OUTPUT, SOURCE, KEEP_NBT);
}
